import { ResinfoService } from './resinfo.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MatSidenavModule} from '@angular/material/sidenav';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import {MatFormFieldModule} from '@angular/material/form-field';
import { RegistService } from './regist.service';
import {MatTabsModule} from '@angular/material/tabs';
import { ResRegistComponent } from './res-regist/res-regist.component';
import { ShowResComponent } from './show-res/show-res.component';
import {MatSelectModule} from '@angular/material/select';
import { ShowService } from './show.service';
import { ResinfoComponent } from './resinfo/resinfo.component';


const appRoutes: Routes = [
  {
    path: '',
    redirectTo: 'res-regist',
    pathMatch: 'full'
    },
    {
      path: 'res-regist',
      component: ResRegistComponent
      },
      {
        path: 'show-res',
        component: ShowResComponent
        },
        { path: 'res-info/:rid',
        component: ResinfoComponent },

];

@NgModule({
  declarations: [
    AppComponent,
    ResRegistComponent,
    ShowResComponent,
    ResinfoComponent,

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    FormsModule,
    MatSidenavModule,
    RouterModule.forRoot(appRoutes),
    MatFormFieldModule,
    MatTabsModule,
    MatSelectModule

  ],
  providers: [RegistService, ShowService],
  bootstrap: [AppComponent]
})
export class AppModule { }
