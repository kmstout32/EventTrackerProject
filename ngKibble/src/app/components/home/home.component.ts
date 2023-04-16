import { Kibble } from './../../models/kibble';
import { Component, OnInit } from '@angular/core';
import { KibbleService } from 'src/app/services/kibble.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  [x: string]: any;

  kibbles: Kibble[] = [];
  selected: Kibble | null = null;
  selectedNew: Kibble | null = null;
  addKib: boolean | null = false;
  newKibble: Kibble = new Kibble();
  title: String = 'Amount of Kibbles';
  editKibble: Kibble | null = null;

  constructor(private kibbleService: KibbleService) {}

  ngOnInit(): void {
    this.loadKibble();
  }


  loadKibble() {
    this.kibbleService.index().subscribe({
      next: (kibbleList) => {
        this.kibbles = kibbleList;
      },
      error: (failure) => {
        console.error('Error getting kibble list fron service');
        console.log(failure);
      },
    });
  }

  setSelectedKibble(kib: Kibble) {
    this.selected = kib;
  }

  setAddKibble(){
    this.addKib = true;
  }

  addKibble(newKibble: Kibble) {
    console.log(newKibble);
    this.kibbleService.create(newKibble).subscribe({
      next: (createkibble) => {
        console.log('Kibble Created: ');
        console.log(createkibble);
        this.selected = createkibble;
        this.loadKibble();
        this.displayTable();
      },
      error: (ohno) => {
        console.error('Oops, error creating kibble: ');
        console.error(ohno);
      },
    });
  }

  kibbleCount(): number {
    return this.kibbles.length;
  }

  reload(){
    this.kibbleService.index().subscribe({
      //when the next piece of data arrives- without error my todos will go here
      next: (kibbleList)=>{ this.kibbles = kibbleList},
      // or when it goes wrong
      error: (failure)=> {
        console.error('Error getting Todo List');
        console.error(failure);
      }
    });

  }

  displayKibble(kibble: Kibble){
    this.selected = kibble;
  }

  displayTable(){
    this.selected =null;
  }

  deleteKibble(kibbleId: number){
    this.kibbleService.destory(kibbleId).subscribe({
      next: (deleteKib)=> {
        this.reload();
      },
      error:(boom)=>{
        console.error('Error creating kibble');
        console.log(boom);
      }
    });
  }

  setEditKibble(){
    this.editKibble = Object.assign({}, this.selected);
  }

  updateKibble(kibble: Kibble){
    this.kibbleService.update(kibble).subscribe({
      next: (updateKibble)=> {
        this.editKibble = null;
        this.reload();
        this.displayTable();
      },
      error:(boom)=>{
        console.error('Error creating kibble');
        console.log(boom);
      }
    });
  }
}
