package scalaoops

object Enums{
  /**
   * enum is a datatype so we can add methods or fields.
   */
  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    def openDocument(): Unit = {
      if (this == READ) println("Opening document")
      else println("Reading not allowed")
    }
  }
    val somePermission:Permissions=Permissions.READ


  /**
   * 1.Enums can take constructor args.
   */
  enum PermissionWithBits(bits:Int){
    case READ extends PermissionWithBits(4)
    case WRITE extends PermissionWithBits(2)
    case EXECUTE extends PermissionWithBits(1)
    case NONE extends PermissionWithBits(0)
  }

  /**
   * 2.Enum can have companion objects.
   */
  object PermissionWithBits{
    def fromBits(bits:Int):PermissionWithBits={
      PermissionWithBits.NONE
    }
  }

  /**
   * Standard API for enum.
   */
  val somePermissionsOrdinal: Int =somePermission.ordinal
  val allPermissions: Any =PermissionWithBits.values //array of all possible values of the enum
  val readPermission: Permissions = Permissions.valueOf("READ") //No arg constructor is required

  def main(args: Array[String]): Unit = {
    somePermission.openDocument()
    println(somePermissionsOrdinal)
    println(allPermissions)
  }
}
