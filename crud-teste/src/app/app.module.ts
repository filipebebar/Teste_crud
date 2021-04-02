import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {NgxPaginationModule} from 'ngx-pagination';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {ApiBackendService} from './service/api-backend.service';
import {FormsModule} from '@angular/forms';
import {NotifierModule} from 'angular-notifier';
import {NgxBootstrapIconsModule} from 'ngx-bootstrap-icons';
import {allIcons} from 'ngx-bootstrap-icons';
import {NgxMaskModule, IConfig} from 'ngx-mask';

import {AppComponent} from './app.component';

export const options: Partial<IConfig> | (() => Partial<IConfig>) = null;

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    NgxPaginationModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    NotifierModule,
    NgxBootstrapIconsModule.forRoot(allIcons),
    NgxMaskModule.forRoot(),
  ],
  providers: [HttpClientModule, ApiBackendService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
