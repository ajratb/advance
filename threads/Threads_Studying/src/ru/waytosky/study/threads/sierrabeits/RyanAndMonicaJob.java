/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky.study.threads.sierrabeits;

/**
 *
 * @author ayrat
 */
public class RyanAndMonicaJob implements Runnable{
    
    private BankAccount account = new BankAccount();

    public static void main(String[] args) {
        RyanAndMonicaJob theJob = new RyanAndMonicaJob();
        Thread ryan=new Thread(theJob);
        Thread monica=new Thread(theJob);
        ryan.start();
        monica.start();
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            makeWithdrawl(10);
            if(account.getBalance()<0){
                System.out.println("Превышение лимита!");
            }
        }
    }

    private synchronized void makeWithdrawl(int amount) {
        if(account.getBalance()>=amount){
            System.out.println(Thread.currentThread().getName()+
                    " собирается снять деньги"); 
            try{
                System.out.println(Thread.currentThread().getName()+
                    " идет подремать");
                Thread.sleep(500);
            }catch(InterruptedException ex){ex.printStackTrace();}
            System.out.println(Thread.currentThread().getName()+
                    " просыпается");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName()+
                    " заканчивает транзакцию");
            
        }
        else{
            System.out.println("Извининте, для клиента "+
                    Thread.currentThread().getName()+" недостаточно денег");
        }
    }
}
