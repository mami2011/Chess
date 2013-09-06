package com.vendertool.registration.dal.dao;

import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.mysema.query.Tuple;
import com.mysema.query.sql.RelationalPath;
import com.mysema.query.sql.dml.Mapper;
import com.mysema.query.types.Path;
import com.vendertool.common.dal.exception.DatabaseException;
import com.vendertool.common.validation.ValidationUtil;
import com.vendertool.registration.dal.dao.codegen.QAccount;
import com.vendertool.sharedtypes.core.Account;
import com.vendertool.sharedtypes.core.AccountRoleEnum;
import com.vendertool.sharedtypes.core.AccountStatusEnum;
import com.vendertool.sharedtypes.core.Address;
import com.vendertool.sharedtypes.core.ContactDetails;
import com.vendertool.sharedtypes.core.Image;
import com.vendertool.sharedtypes.core.Language;

public class AccountMapper implements Mapper<Account> {
//	private static final Logger logger = Logger.getLogger(AccountMapper.class);
	ValidationUtil VUTIL = ValidationUtil.getInstance();

	private Account account;
	Path<?>[] paths;
	
	public Account getAccount() {
		return account;
	}

	AccountMapper(Account account, Path<?>[] paths) throws DatabaseException {
		if(VUTIL.isNotNull(paths) || VUTIL.isNotNull(account)) {
			throw new DatabaseException("Null value passed to the mapper");
		}
		this.account = account;
		this.paths = paths;
	}

	@Override
	public Map<Path<?>, Object> createMap(RelationalPath<?> path,
			Account object) {
		QAccount a = QAccount.account;
		
		Map<Path<?>, Object> map = new HashMap<Path<?>, Object>();
		
		for(Path<?> rpath : paths) {
			if(a.accountId.equals(rpath)) {
				map.put(a.accountId, account.getId());
			}
			
			if(a.alternateEmail.equals(rpath)) {
				map.put(a.alternateEmail, account.getAlternateEmailId());
			}

			if(a.billingAddrId.equals(rpath)) {
				map.put(a.billingAddrId, 
						(account.getBillingAddress() != null) ? 
								account.getBillingAddress().getId() : null);
			}
			
			if(a.createdDate.equals(rpath)) {
				map.put(a.createdDate, account.getCreateDate());
			}
			
			if(a.currencyCodeIso3.equals(rpath)) {
				map.put(a.currencyCodeIso3, 
						(account.getCurrency() != null) ? 
								account.getCurrency().getCurrencyCode() : null);
			}
			
			if(a.emailAddr.equals(rpath)) {
				map.put(a.emailAddr, account.getEmailId());
			}
			
			if(a.firstName.equals(rpath)) {
				map.put(a.firstName, 
						(account.getContactDetails() != null) ? 
								account.getContactDetails().getFirstName() : null);
			}

			if(a.language.equals(rpath)) {
				Language lang = account.getLanguage();
				if(lang != null) {
					map.put(a.language, lang.getIsoLangCode());
				}
				map.put(a.language, null);
			}
			
			if(a.lastModifiedApp.equals(rpath)) {
				//for now put null we need to figure this later
//				map.put(a.lastModifiedApp, null);
			}
			
			if(a.lastModifiedDate.equals(rpath)) {
				map.put(a.lastModifiedDate, new Date());
			}

			if(a.lastName.equals(rpath)) {
				map.put(a.lastName, 
						(account.getContactDetails() != null) ? 
								account.getContactDetails().getLastName() : null);
			}
			
			if(a.middleName.equals(rpath)) {
				map.put(a.middleName, 
						(account.getContactDetails() != null) ? 
								account.getContactDetails().getMiddleName() : null);
			}

			if(a.password.equals(rpath)) {
				map.put(a.password, account.getPassword());
			}
			
			if(a.picture.equals(rpath)) {
				map.put(a.picture, (account.getPicture() != null) ? account
						.getPicture().getBytes() : null);
			}

			if(a.registrationAddrId.equals(rpath)) {
				map.put(a.registrationAddrId,
						((account.getContactDetails() != null) && (account
								.getContactDetails().getAddress() != null)) ? account
								.getContactDetails().getAddress().getId()
								: null);
			}
			
			if(a.roles.equals(rpath)) {
				Set<AccountRoleEnum> roles = account.getRoles();
				if((roles == null) || (roles.isEmpty())) {
					map.put(a.roles, null);
				}
				map.put(a.roles, account.normalize(roles));
			}
			
			if(a.salt.equals(rpath)) {
				map.put(a.salt, account.getPasswordSalt());
			}
			
			if(a.status.equals(rpath)) {
				map.put(a.status, account.getAccountStatus().getId());
			}
		}
		
		return map;
	}

	public Path<?>[] getPaths() {
		return paths;
	}
	
	public static Account convert(Tuple row, Path<?>[] paths) {
		if((row == null) || (paths == null) || (paths.length <= 0)) {
			return null;
		}
		
		QAccount a = QAccount.account;
		Account account = new Account();
		
		for(Path<?> rpath : paths) {
			if(a.accountId.equals(rpath)) {
				account.setId(row.get(a.accountId));
			}
			
			if(a.alternateEmail.equals(rpath)) {
				account.setAlternateEmailId(row.get(a.alternateEmail));
			}

			if(a.billingAddrId.equals(rpath)) {
				Address baddr = account.getBillingAddress();
				if(baddr == null) {
					baddr = new Address();
					account.setBillingAddress(baddr);
				}
				
				baddr.setId(row.get(a.billingAddrId));
			}
			
			if(a.createdDate.equals(rpath)) {
				account.setCreateDate(row.get(a.createdDate));
			}
			
			if(a.currencyCodeIso3.equals(rpath)) {
				try {
					Currency c = Currency.getInstance(row.get(a.currencyCodeIso3));
					if(c != null) {
						account.setCurrency(c);
					}
				} catch (Exception e) {
					account.setCurrency(null);
				}
			}
			
			if(a.emailAddr.equals(rpath)) {
				account.setEmailId(row.get(a.emailAddr));
			}
			
			if(a.firstName.equals(rpath)) {
				ContactDetails cd = account.getContactDetails();
				if(cd == null) {
					cd = new ContactDetails();
					account.setContactDetails(cd);
				}
				cd.setFirstName(row.get(a.firstName));
			}

			if(a.language.equals(rpath)) {
				String langCode = row.get(a.language);
				if(langCode != null) {
					Language lang = Language.getLanguage(langCode);
					if(lang != null) {
						account.setLanguage(lang);
					}
				}
			}
			
			if(a.lastModifiedApp.equals(rpath)) {
				//for now put null we need to figure this later
//				map.put(a.lastModifiedApp, null);
			}
			
			if(a.lastModifiedDate.equals(rpath)) {
				account.setLastModifiedDate(row.get(a.lastModifiedDate));
			}

			if(a.lastName.equals(rpath)) {
				ContactDetails cd = account.getContactDetails();
				if(cd == null) {
					cd = new ContactDetails();
					account.setContactDetails(cd);
				}
				cd.setLastName(row.get(a.lastName));
			}
			
			if(a.middleName.equals(rpath)) {
				ContactDetails cd = account.getContactDetails();
				if(cd == null) {
					cd = new ContactDetails();
					account.setContactDetails(cd);
				}
				cd.setMiddleName(row.get(a.middleName));
			}

			if(a.password.equals(rpath)) {
				account.setPassword(row.get(a.password));
			}
			
			if(a.picture.equals(rpath)) {
				byte[] bytes = row.get(a.picture);
				if((bytes == null) || (bytes.length <= 0)) {
					account.setPicture(null);
				}
				Image img = new Image();
				img.setBytes(bytes);
				account.setPicture(img);
			}

			if(a.registrationAddrId.equals(rpath)) {
				ContactDetails cd = account.getContactDetails();
				if(cd == null) {
					cd = new ContactDetails();
					cd.setAddress(new Address());
					account.setContactDetails(cd);
				}
				if(cd.getAddress() == null) {
					cd.setAddress(new Address());
				}
				cd.getAddress().setId(row.get(a.registrationAddrId));
			}
			
			if(a.roles.equals(rpath)) {
				String roles = row.get(a.roles);
				if((roles == null) || (roles.trim().isEmpty())) {
					account.setRoles(null);
				}
				account.setRoles(account.denormalize(roles));
			}
			
			if(a.salt.equals(rpath)) {
				account.setPasswordSalt(row.get(a.salt));
			}
			
			if(a.status.equals(rpath)) {
				int sid = row.get(a.status);
				AccountStatusEnum se = AccountStatusEnum.get(sid);
				if(se == null) {
					account.setAccountStatus(null);
				}
				account.setAccountStatus(se);
			}
		}
		
		return account;
	}
	
}