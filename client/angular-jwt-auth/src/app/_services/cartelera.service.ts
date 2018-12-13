import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment as env } from 'environments/environment';

import { Cartelera } from '@/_models/Cartelera';

@Injectable({ providedIn: 'root' })
export class CarteleraService {
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<Cartelera[]>(`${env.url}/cartelera`);
    }
}