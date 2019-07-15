import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

//Models
import { Pokemon } from '../models/pokemon.model';

@Injectable()
export class PokemonService {

    //Injecting the http object
    constructor(private http: HttpClient) {}
    error :any;

    public fetchPokemonInformation(id: number): Observable<Pokemon> {
        return this.http
                .get<Pokemon>(`https://pokeapi.co/api/v2/pokemon/${id}`)
                .pipe(catchError(this.handleError));
    }

    private handleError(error: HttpErrorResponse) {
        return Observable.throw(error.statusText);
    }
}