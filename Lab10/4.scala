object Q4 {
  case class Account(id: Int, balance: Double)

  case class Bank(accounts: List[Account]) {

    def accountsWithNegativeBalances: List[Account] =
      accounts.filter(_.balance < 0)

    def totalBalance: Double =
      accounts.map(_.balance).sum

    def applyInterest: List[Account] =
      accounts.map { account =>
        val interestRate = if (account.balance > 0) 0.05 else 0.1
        val newBalance = account.balance + account.balance * interestRate
        account.copy(balance = newBalance)
      }
  }

  def main(args: Array[String]): Unit = {
    val acc1 = Account(1, 100.0)
    val acc2 = Account(2, -50.0)
    val acc3 = Account(3, 200.0)
    val bank = Bank(List(acc1, acc2, acc3))

    println(
      s"Accounts with negative balances: ${bank.accountsWithNegativeBalances}"
    )
    println(s"Total balance: ${bank.totalBalance}")
    println(s"Final balances after interest: ${bank.applyInterest}")
  }
}
