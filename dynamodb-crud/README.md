# AWS
Guide: https://aws.amazon.com/blogs/database/amazon-dynamodb-single-table-design-using-dynamodbmapper-and-spring-boot/

Tip: Don't use IAM User credentials on EC2 unless you absolutely have to. Instead, launch the EC2 instance with an appropriate IAM Role (or edit the instance later to apply an IAM Role). The SDK will then automatically retrieve credentials and they will be auto-rotated for you (unlike IAM User credentials, which are fixed and hence your exposure is greater).
For local test the IAM User Credential could be acceptable

For local test create the following ENVIROMENT:
AWS_ACCESS_KEY_ID=KEY
AWS_SECRET_ACCESS_KEY=SECRET