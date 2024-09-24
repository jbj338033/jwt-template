# Clone the repository
git clone https://github.com/jbj338033/jwt-template.git

# Set Environment Variables
export DATABASE_URL="Your Database URL"
export DATABASE_USERNAME="Your Database Username"
export DATABASE_PASSWORD="Your Database Password"
export REDIS_HOST="Your Redis Host"
export REDIS_PORT="Your Redis Port"
export REDIS_PASSWORD="Your Redis Password"
export JWT_SECRET_KEY="Your JWT Secret Key"
export JWT_ACCESS_TOKEN_EXPIRATION="Your JWT Access Token Expiration"
export JWT_REFRESH_TOKEN_EXPIRATION="Your JWT Refresh Token Expiration"

# Run the application
./gradlew bootRun