package src.secureCoding;

public class BlockInjectionAndInclusion {
    /**
     * Steps to avoid injection
     * --> identify the use case
     * --> use a library
     * --> trurn of feature
     * SQL injection appears when in the API of the request fetching datas there a sql commands
     * For those the injection can permit to retrieve datas of all the other tables
     * Example:
     * GET
     * /message?forum=1%27+UNION+ALL+SELECT+TABLE_NAME+FROM+INFORMATION_SCHEMA.TABLES--
     * it correspond to
     * SELECT * FROM messages where forum = 1 UNION ALL SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES
     * How to prevent it:
     * In JDBC we can use preparedStatement instead of statement but it is always possible to make injection
     * in the preparedStatement when enforcing
     * Steps to avoid injection
     * --> canocicalize the input i.e. set the correct type
     * for example we can make sure in the api that the type of data sent is Long so it will block
     * when someone try to inject a string
     * We can prevent it also by putting so condition in our methods
     * --> we can put the length < 500
     * --> we can make an allow list
     * Inclusion consists in adding a reference to a file that can be malicious to our system
     * How to prevent it:
     * --> Do not load files or make an allow list, load only local files
     * --> Load remote https files
     * To prevent injection
     * --> Do not output untrusted data
     * --> Canonicalize and validate inputs
     * --> Encode outputs
     * --> Use an appropriately-configured third party
     * To prevent inclusion
     * --> Do not use untrusted input to load resources
     * --> Load resources locally using allowlist
     */
}
