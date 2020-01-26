import CarType.CarType

object ParkingFloorFinder {
  var floorsForElectricCar: Array[Int] = Array(7, 8)
  var floorsForDieselCar: Array[Int] = Array(0, 1, 2, 3, 4, 5, 6, 7, 8)
  var floorForVan: Array[Int] = Array(0, 1)
  var SpacesInParkingLot: Array[Int] = Array(0, 1, 34, 4, 0, 8, 0, 1, 0)

  def GetAvailableFloor(carType: CarType): Array[Int] = {
    carType match {
      case CarType.Diesel => floorsForDieselCar
      case CarType.Van => floorForVan
      case CarType.Electric => floorsForElectricCar
      case _ => throw new IllegalArgumentException("unknown type")
    }
  }

  def GetFloorToPark(entryFloor: Int, carType: CarType): Option[Int] = {
    if (entryFloor > SpacesInParkingLot.length - 1 || entryFloor < 0) {
      throw new Exception
    }
    if (SpacesInParkingLot(entryFloor) > 0 && GetAvailableFloor(carType).contains(entryFloor)) {
      return Some(entryFloor)
    }
    else {
      for (i <- 1 to SpacesInParkingLot.length) {
        var upperFloor = entryFloor + i
        if (upperFloor >= 0 && upperFloor < SpacesInParkingLot.length) {
          if (SpacesInParkingLot(upperFloor) > 0 && GetAvailableFloor(carType).contains(upperFloor)) {
            return Some(upperFloor)
          }
        }
        var lowerFloor = entryFloor - 1
        if (lowerFloor >= 0 && lowerFloor < SpacesInParkingLot.length) {
          if (SpacesInParkingLot(lowerFloor) > 0 && GetAvailableFloor(carType).contains(lowerFloor)) {
            return Some(lowerFloor)
          }
        }
      }
    }
    return None
  }
}