import { Injectable } from '@angular/core';
import { Juego } from './juego';
import { JUEGOS } from './mock-juegos';
import { Observable, of } from 'rxjs';
import { MessageService } from './message.service';
@Injectable({
  providedIn: 'root'
})
export class JuegoService {
  getJuegos(): Observable<Juego[]> {
    this.messageService.add('JuegoService: fetched juegos');
    return of(JUEGOS);
  }

  constructor(private messageService: MessageService) { }
}
