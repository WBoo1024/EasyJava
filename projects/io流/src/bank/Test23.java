package bank;

import java.io.Serializable;

/**
 * @author WANG
 * @date 2022/5/28 11:47
 */
public class Test23 implements Serializable {
    private int id;
    private String name;
    private int balance;


    public Test23(int id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Test23() {
    }

    @Override
    public String toString() {
        return
                "储户ID：" + id + "\t姓名：" + name + "\t账户余额：" + balance;
    }
}
