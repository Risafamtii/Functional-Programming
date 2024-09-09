object Q3 {
  def main(args: Array[String]): Unit = {
    val account1 = new Account(1000)
    val account2 = new Account(500)

    println(
      s"Initial Balances: Account1: ${account1.balance}, Account2: ${account2.balance}"
    )

    val updatedAccount1 = account1.deposit(200)
    println(s"After depositing 200 into Account1: ${updatedAccount1.balance}")

    val updatedAccount1AfterWithdraw = updatedAccount1.withdraw(150)
    println(
      s"After withdrawing 150 from Account1: ${updatedAccount1AfterWithdraw.balance}"
    )

    val (updatedAccount1AfterTransfer, updatedAccount2) =
      updatedAccount1AfterWithdraw.transfer(account2, 300)
    println(s"After transferring 300 from Account1 to Account2:")
    println(s"Account1: ${updatedAccount1AfterTransfer.balance}")
    println(s"Account2: ${updatedAccount2.balance}")
  }
}

class Account(val balance: Double) {

  def deposit(amount: Double): Account = {
    val newBalance = amount match {
      case x if x > 0 => balance + x
      case _          => balance
    }
    new Account(newBalance)
  }

  def withdraw(amount: Double): Account = {
    val newBalance = amount match {
      case x if x > 0 && x <= balance => balance - x
      case _                          => balance
    }
    new Account(newBalance)
  }

  def transfer(to: Account, amount: Double): (Account, Account) = {
    val (updatedFrom, updatedTo) = (
      amount match {
        case x if x > 0 && x <= balance => new Account(balance - x)
        case _                          => this
      },
      to.deposit(amount match {
        case x if x > 0 && x <= balance => x
        case _                          => 0
      })
    )
    (updatedFrom, updatedTo)
  }
}
