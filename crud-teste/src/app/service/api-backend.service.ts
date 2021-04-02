import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Desenvolvedor} from './desenvolvedor';
import {environment} from '../../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class ApiBackendService {
  constructor(private http: HttpClient) {

  }

  // apiUrl: string = environment.apiURL;

  apiUrl: string = environment.testApiURL;

  listAll(): Observable<Desenvolvedor> {
    return this.http.get<Desenvolvedor>(this.apiUrl);
  }

  save(desenvolvedor: Desenvolvedor): Observable<Desenvolvedor> {
    return this.http.post<Desenvolvedor>(this.apiUrl + '/', desenvolvedor);
  }

  deletar(id: number): Observable<void> {
    return this.http.delete<void>(this.apiUrl + '/' + id);
  }

  atualizar(desenvolvedor: Desenvolvedor): Observable<Desenvolvedor> {
    return this.http.delete<Desenvolvedor>(this.apiUrl + '/' + desenvolvedor.id);
  }

}
