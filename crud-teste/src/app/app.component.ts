import {Component, OnInit} from '@angular/core';
import {ApiBackendService} from './service/api-backend.service';
import {NotifierService} from 'angular-notifier';
import {Desenvolvedor} from './service/desenvolvedor';

declare var jQuery: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  private readonly notifier: NotifierService;
  dev: Desenvolvedor = new Desenvolvedor();

  desenvolvedores: Desenvolvedor;
  editingDev = false;


  constructor(private desenvolvedorService: ApiBackendService, notifierService: NotifierService) {
    this.notifier = notifierService;
  }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.listarDevs();
  }

  // tslint:disable-next-line:typedef
  listarDevs() {
    this.desenvolvedorService.listAll().subscribe(desenvolvedores => {

      this.desenvolvedores = desenvolvedores;
      console.log(desenvolvedores);
    }, error => {
      console.log('Erro ao listar pessoas');
    });
  }

  // tslint:disable-next-line:typedef
  salvar() {
    if (this.dev) {
      if (!this.dev.id) {
        this.desenvolvedorService.save(this.dev).subscribe(dev => {
          this.listarDevs(),
            this.dev.nome = '',
            this.dev.sexo = '',
            this.dev.idade = '',
            this.dev.hobby = '',
            this.dev.dataNascimento = '';
        }, error => {
          console.log('Erro ao cadastrar');
        });
      } else {
        this.desenvolvedorService.atualizar(this.dev).subscribe(dev => {
          this.listarDevs();
        }, error => {
          console.log('Erro ao Atualizar');
        });
      }
    } else {

    }
  }

  // tslint:disable-next-line:typedef
  editarDev(dev) {
    this.dev = dev;
    console.log(dev);
    this.editingDev = true;
  }


  // tslint:disable-next-line:typedef
  cancelarEdicao() {
    this.editingDev = false;
  }

  // tslint:disable-next-line:typedef
  deletarDev(dev) {
    this.desenvolvedorService.deletar(dev.id).subscribe({
      next: (response) => this.listarDevs()
    });
  }
}
