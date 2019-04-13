package com.viaflow.manager.api.security.ldap;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.viaflow.manager.api.security.jwt.JwtAuthenticationRequest;

@Component
public class LdapAuth {
	
	@Value("${ldap.initialContext}")
	private String initialContext;
	
	@Value("${ldap.ldapUrl}")
	private String ldapUrl;
	
	@Value("${ldap.user}")
	private String ldapUser;
	
	@Value("${ldap.pass}")
	private String ldapPass;
	
	public boolean authenticate(JwtAuthenticationRequest user) throws Exception {
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, this.initialContext);
	    props.put(Context.PROVIDER_URL, ldapUrl);
	    props.put(Context.SECURITY_PRINCIPAL, ldapUser);
	    props.put(Context.SECURITY_CREDENTIALS, ldapPass);//dn user password

	    InitialDirContext context = new InitialDirContext(props);

	    SearchControls ctrls = new SearchControls();
	    ctrls.setSearchScope(SearchControls.SUBTREE_SCOPE);

	    String searchFilter = "(&(objectClass=user)(sAMAccountName=" + user.getLogin() + "))";
	    NamingEnumeration<javax.naming.directory.SearchResult> answers = context.search("DC=viaflow,DC=net", searchFilter, ctrls);
	    javax.naming.directory.SearchResult result = answers.nextElement();

	    String userName = result.getNameInNamespace();

	    props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, this.initialContext);
	    props.put(Context.PROVIDER_URL, ldapUrl);
        props.put(Context.SECURITY_PRINCIPAL, userName);
        props.put(Context.SECURITY_CREDENTIALS, user.getPassword());

        context = new InitialDirContext(props);
	    
	    return true;
	}
}
