import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { UserListComponent } from './user-list/user-list.component';
import { UserCreateComponent } from './user-create/user-create.component';
import { UserService } from "./user.service";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    UserRoutingModule,
	FormsModule,
	ReactiveFormsModule
  ],
   providers: [UserService],
  declarations: [UserListComponent, UserCreateComponent]
})
export class UserModule { }
