import { Component, OnInit } from '@angular/core';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpClient } from '@angular/common/http';
import { FormGroup, Validators, FormControl, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-listofstores',
  templateUrl: './listofstores.component.html',
  styleUrls: ['./listofstores.component.scss'],
})
export class ListofstoresComponent implements OnInit {
  createModalRef: NgbModalRef;
  createStoreForm: FormGroup;
  addressName: String;
  latitude: String;
  longitude: String;
  list: any;
  constructor(private modal: NgbModal, private fb: FormBuilder, private httpClient: HttpClient) { }
  ngOnInit() {
    this.createStoreForm = this.fb.group({
      storeName: new FormControl('', [Validators.required]),
      category: new FormControl('', [Validators.required]),
      ownerName: new FormControl('', [Validators.required])
    });
    this.httpClient.get('http://localhost:8080/api/store/getStores?storeName=').subscribe((res) => {
      this.list = res;
    });
  }
  getAddress(place) {
    if (place.geometry) {
      let lat = place.geometry.location.lat();
      let lng = place.geometry.location.lng();
      this.httpClient.get('http://localhost:8080/api/store/getStoresByLocation/lat/' + lat + '/lng/' + lng).subscribe((res) => {
        console.log(res);
        this.list = res;
      });
    } else {
      this.httpClient.get('http://localhost:8080/api/store/getStores?storeName=' + place.name).subscribe((res) => {
        console.log(res);
        this.list = res;
      });
    }
  }
  getAddressFormField(address) {
    this.addressName = address.formatted_address;
    this.latitude = address.geometry.location.lat();
    this.longitude = address.geometry.location.lng();
  }
  addStore(createStore) {
    this.createModalRef = this.modal.open(createStore);
  }
  createStores() {
    let reqObj = {
      storeName: this.createStoreForm.get('storeName').value,
      category: this.createStoreForm.get('category').value,
      storeAddress: this.addressName,
      latitude: this.latitude,
      longitude: this.longitude,
      ownerName: this.createStoreForm.get('ownerName').value
    };
    this.httpClient.post('http://localhost:8080/api/store/create', reqObj).subscribe((res) => {
      if (res) {
        this.createModalRef.close();
        this.ngOnInit();
      }
    });
  }

}
