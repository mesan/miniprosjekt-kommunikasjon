namespace java no.mesan.miniprosjekt.kommunikasjon.thrift  // defines the namespace   
  
typedef i32 int  //typedefs to get convenient names for your types  

struct Kaja {
	1: list<int> kj;
}
  
service AdditionService {  // defines the service to add two numbers  
        Kaja hent(), //defines a method  
}  