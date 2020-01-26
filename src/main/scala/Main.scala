import CarType.CarType

object Main {
  def main(args: Array[String]): Unit = {

    val carType = GetCarTypeFromPlateNumber(scala.io.StdIn.readLine("Enter car plate: "))
    println("Enter car entry floor from -2 to 6: ")
    var carFloor = scala.io.StdIn.readInt()
    var parkingFloor = ParkingFloorFinder.GetFloorToPark(ConvertFromInputFloor(carFloor), carType)

    if (parkingFloor.isDefined) {
      println(s"You can park in ${ConvertToInputFloor(parkingFloor.get)}")
    }
    else {
      println("There isn't any free space, you must wait")
    }
  }

  def GetCarTypeFromPlateNumber(plateNumber: String): CarType = {
    if (plateNumber.toUpperCase().contains("A")) {
      return CarType.Diesel
    }
    else if (plateNumber.toUpperCase().contains("W")) {
      return CarType.Electric
    }
    else {
      return CarType.Van
    }
  }

  def ConvertFromInputFloor(floor: Int): Int = {
    return floor + 2
  }

  def ConvertToInputFloor(floor: Int): Int = {
    return floor - 2
  }
}
