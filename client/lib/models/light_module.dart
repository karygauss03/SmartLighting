
import 'package:flutter/cupertino.dart';

import './resource.dart';

class LightModule implements Resource{
  String id;
  double lon;   // longitude
  double lat;   // latitude
  String address;
  bool isOn; // on or off;
  bool isBroken;
  bool archived;
  String createdOn;
  bool isApproved;

  LightModule({required this.id, required this.lon, required this.lat, required this.address, required this.archived, required this.createdOn, required this.isApproved, required this.isBroken, required this.isOn});

  @override
  LightModule fromJson(dynamic json){
    return LightModule(address: json["addressId"]??"", archived: json["archived"]??"", createdOn: json["created_on"]??"", id: json["id"]??"", isApproved: json["approved"]??true, isBroken: json["broken"]??false, isOn: json["on"]??true, lat: json["lat"]??95.12, lon: json["lon"]??-70.16);
  }
}