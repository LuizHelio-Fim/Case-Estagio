import { Component, OnDestroy, OnInit, inject, signal } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { AlunoService } from 'app/entities/aluno/service/aluno.service';
import { MetaService } from 'app/entities/meta/service/meta.service';
import { IMeta } from 'app/entities/meta/meta.model';
import SharedModule from 'app/shared/shared.module';
import { AccountService } from 'app/core/auth/account.service';
import { Account } from 'app/core/auth/account.model';

interface MediaNotas {
  linguagens: number;
  humanas: number;
  natureza: number;
  matematica: number;
}

@Component({
  selector: 'jhi-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
  imports: [SharedModule, RouterModule],
})
export default class HomeComponent implements OnInit, OnDestroy {
  totalAlunos = 0;
  mediaNotas: MediaNotas = { linguagens: 0, humanas: 0, natureza: 0, matematica: 0 };

  account = signal<Account | null>(null);
  private readonly destroy$ = new Subject<void>();

  private readonly accountService = inject(AccountService);
  private readonly router = inject(Router);

  constructor(
    private alunoService: AlunoService,
    private metaService: MetaService,
  ) {}

  ngOnInit(): void {
    this.alunoService
      .query()
      .pipe(takeUntil(this.destroy$))
      .subscribe(response => {
        this.totalAlunos = response.body?.length ?? 0;
      });

    this.metaService
      .query()
      .pipe(takeUntil(this.destroy$))
      .subscribe(response => {
        const metas = response.body ?? [];

        const total = metas.length;
        if (total === 0) return;

        let somaLinguagens = 0;
        let somaHumanas = 0;
        let somaNatureza = 0;
        let somaMatematica = 0;

        metas.forEach(meta => {
          somaLinguagens += Number(meta.linguagem) || 0;
          somaHumanas += Number(meta.humanas) || 0;
          somaNatureza += Number(meta.natureza) || 0;
          somaMatematica += Number(meta.matematica) || 0;
        });

        this.mediaNotas = {
          linguagens: somaLinguagens / total,
          humanas: somaHumanas / total,
          natureza: somaNatureza / total,
          matematica: somaMatematica / total,
        };
      });

    this.accountService
      .getAuthenticationState()
      .pipe(takeUntil(this.destroy$))
      .subscribe(account => this.account.set(account));
  }

  login(): void {
    this.router.navigate(['/login']);
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }
}
