

import './resource.dart';

class Assignment implements Resource{
  String id;
  String employeeId;
  String lightModuleId;
  bool isRepaired;
  String completionDate;

  Assignment({required this.id, required this.employeeId, required this.lightModuleId, required this.completionDate, required this.isRepaired});

  @override
  Assignment fromJson(dynamic json){
    return Assignment(id: json["assignmentId"]??"", employeeId: json["employeeId"]??"", lightModuleId: json["lightingModuleId"]??"", completionDate: json["repairedDate"]??"", isRepaired: json["repaired"]??true);
  } 

  // @override
  // dynamic toJson(Assignment assignment){

  // }

}