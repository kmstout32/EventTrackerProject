export class Kibble {
  id: number;
  name: string;
  kibbleUrl: string;
  // createDate: Date;
  result: string;
  protein: string;


  constructor(
    id: number = 0,
    name: string = '',
    kibbleUrl: string = '',
    // createDate: Date,
    result: string= '',
    protein: string= ''

  ){
    this.id = id;
    this.name = name;
    this.kibbleUrl = kibbleUrl;
    // this.createDate = this.createDate;
    this.result = result;
    this.protein = protein;
  }
}
