package Jobs

/**
  * Store CockroachDB connection properties so that I don't have to do this all over the place
  */
trait DBConnection {
  // CockroachDB settings
  // This String value must be changed to point to the public ip assigned by
  // Kubernetes for CockroachDB
  private val host: String = "a2cfda652a1db11e8b8ec021f00e2be9-1169393693.us-west-2.elb.amazonaws.com"
  private val port: Int = 26257
  private val database: String = "insight"
  private val user: String = "maxroach"
  private val password: String = ""
  
  // Build the inherited members
  final val connectionString = s"jdbc:postgresql://$host:$port/$database?sslmode=disable"
  final val jdbcProperties = new java.util.Properties
  jdbcProperties.setProperty("driver", "org.postgresql.Driver")
  jdbcProperties.setProperty("user", s"$user")
  jdbcProperties.setProperty("password", s"$password")
}
