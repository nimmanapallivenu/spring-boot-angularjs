export class User {
  id: number;
  name: string;
  email: string;
  pwd:string;
  street: string;
  city: string;
  contry: string;
  pincode: string;
 
  constructor(id: number, name: string, pwd: string, email: string, street: string, city: string, contry: string,  pincode: string){
    this.id = id;
    this.name = name;
	this.pwd = pwd;
    this.email = email;
	this.street = street;
	this.city = city;
	this.contry = contry;
	this.pincode = pincode;
  }
 
}