namespace java no.mesan.miniprosjekt.kommunikasjon.thrift.client  // defines the namespace   
  
typedef i32 int  //typedefs to get convenient names for your types  

struct OsThrift {
	1: string name,
	2: binary system;
}

struct AviationDataThrift {
	1: string id,
	2: string accidentNumber;
}

struct AircraftThrift {
	1: string name,
	2: binary drawing;
}
  
service ThriftService {  // defines the service to add two numbers  
        list<OsThrift> getOs(),
        list<AviationDataThrift> getAviationData(),
        list<AircraftThrift> getAircraft() //defines a method  
}  
