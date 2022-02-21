import { Component, OnInit ,Input} from '@angular/core';
import { Juego } from '../juego';

@Component({
  selector: 'app-juego-detail',
  templateUrl: './juego-detail.component.html',
  styleUrls: ['./juego-detail.component.css']
})
export class JuegoDetailComponent implements OnInit {
  @Input() juego!: Juego;
  constructor() { }

  ngOnInit(): void {
  }

}
