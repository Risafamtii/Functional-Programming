def encrypt(message : String) : String = {
    message.map{
        case x if (x.isLetter) => (x+1).toChar ;
        case other => other ;
    }.mkString ;
}

def decrypt(message : String) : String = {
    message.map{
        case x if (x.isLetter) => (x-1).toChar ;
        case other => other ;
    }.mkString ;
}

object question1 extends App {
    println("Enter A Message You Want To Encrypt : ") ;
    val m1 = scala.io.StdIn.readLine() ;

    val encryptm1 = encrypt(m1) ;
    println("The Encrypted Form Of The Message You Entered Is: " + encryptm1) ;

    val decryptm1 = decrypt(encryptm1) ;
    println("The Decrypted Form Of The Encryped Message Is: "+decryptm1) ;
}