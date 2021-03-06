package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import domain.*;
import service.AccountService2;

public class AccountServiceImpl2 implements AccountService2{
	List<AccountBean> list;
		
	public AccountServiceImpl2() {
		list = new ArrayList<>();
	}
	
	@Override
	public void creataAccount(AccountBean account) {
		list.add(account);
	}

	@Override
	public List<AccountBean> list() {
		return list;
	}

	@Override
	public List<AccountBean> search(String word) {
		List<AccountBean> temp = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(word.equals(list.get(i).getName())) {
				temp.add(list.get(i));
			}
		}
		return temp;
	}

	@Override
	public AccountBean search(AccountBean account) {
		AccountBean temp = new AccountBean();
		for(int i=0;i<list.size();i++) {
			if(account.getUid().equals(list.get(i).getUid())) {
				temp = list.get(i);break;
			}
		}
		return temp;
	}

	@Override
	public void update(AccountBean account) {
	/*	AccountBean temp = new AccountBean();
		temp = search(account); 
		list.remove(temp);
		temp.setPass(account.getPass());
		list.add(temp);*/
		 list.get(list.indexOf(search(account))).setPass(account.getPass());
		// list.get(list.indexOf(search(acc))).setPass(acc.getPass());
	}

	@Override
	public void delete(AccountBean account) {
		list.remove(search(account));
		
	}
	
}






