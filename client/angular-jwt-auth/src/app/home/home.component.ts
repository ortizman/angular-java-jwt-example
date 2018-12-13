import { Component } from '@angular/core';
import { first } from 'rxjs/operators';

import { CarteleraService } from '../_services';
import { Cartelera } from '@/_models/Cartelera';

@Component({ templateUrl: 'home.component.html' })
export class HomeComponent {

    carteleras: Cartelera[] = [];
    error: string = '';
    loading: boolean = false;

    constructor(private carteleraService: CarteleraService) { }

    ngOnInit() {

        this.loading = true;
        this.carteleraService.getAll()
            .subscribe(
                data => {
                    this.loading = false;
                    this.carteleras = data;
                },
                error => {
                    this.error = 'No se pudieron cargar las carteleras';
                    this.loading = false;
                    console.error(error);
                }
            )
    }
}