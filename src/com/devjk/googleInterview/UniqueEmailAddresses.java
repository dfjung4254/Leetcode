package com.devjk.googleInterview;

/*

    Google InterView - Unique Email Address
    Every email consists of a local name and a domain name, separated by the @ sign.
    For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
    Besides lowercase letters, these emails may contain '.'s or '+'s.
    If you add periods ('.') between some characters in the local name part of an email address,
    mail sent there will be forwarded to the same address without dots in the local name.

    For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
    (Note that this rule does not apply for domain names.)

    If you add a plus ('+') in the local name, everything after the first plus sign will be ignored.
    This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.
    (Again, this rule does not apply for domain names.)

    It is possible to use both of these rules at the same time.
    Given a list of emails, we send one email to each address in the list.
    How many different addresses actually receive mails?

    Example 1:
        Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
        Output: 2
        Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails

    Note:
        1 <= emails[i].length <= 100
        1 <= emails.length <= 100
        Each emails[i] contains exactly one '@' character.
        All local and domain names are non-empty.
        Local names do not start with a '+' character.

 */

import java.util.HashSet;

public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        HashSet<String> hashSet = new HashSet<>();

        for(String email : emails){

            /* split local and domain name */
            String[] str = email.split("@");
            String local_name = str[0];
            String domain_name = str[1];

            /* extract local name */
            String[] str_ignore_dot = local_name.split("\\.");
            StringBuilder sb = new StringBuilder();
            for(String each : str_ignore_dot){
                sb.append(each);
            }
            String[] str_ignore_plus = sb.toString().split("\\+");
            local_name = str_ignore_plus[0];

            StringBuilder changedMail = new StringBuilder(local_name).append("@").append(domain_name);
            hashSet.add(changedMail.toString());

        }

        return hashSet.size();
    }

}
