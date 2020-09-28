# serverless-scala-aws-s3

El proyecto serverless-scala-aws-s3 define una función lambda de AWS la cual realiza las siguientes operaciones:

1.- Listado de los buckets existentes.
2.- Creación de un bucket en S3
3.- Subida de un fichero a un bucket de S3.
4.- Descarga de un fichero de un bucket de S3. 


## Definición del profile de AWS.
```
export AWS_PROFILE=<PROFILE>
```


## Creación de la función lambda.

```
cd serverless-scala-aws-s3
serverless create --template aws-scala-sbt --path lambda-s3
```


## Creación del artefacto y despliegue.

```
cd myServiceEjem
sbt clean assembly && serverless deploy -r us-east-1
```


## Eliminación de la función lambda en AWS.
```
serverless remove
```

## Referencias

[Librería Scala de AWS utilizada en el proyecto.](https://github.com/seratch/AWScala)

---


# serverless-scala-aws-s3

The serverless-scala-aws-s3 project defines an AWS lambda function which performs the following operations:

1.- List of existing buckets.
2.- Creating a bucket in S3
3.- Uploading a file to an S3 bucket.
4.- Downloading a file from an S3 bucket.


## Definition of the AWS profile.
```
export AWS_PROFILE=<PROFILE>
```


## Creation of the lambda function.

```
cd serverless-scala-aws-s3
serverless create --template aws-scala-sbt --path lambda-s3
```


## Artifact creation and deployment.

```
cd myServiceEjem
sbt clean assembly && serverless deploy -r us-east-1
```


## Eliminación de la función lambda en AWS.
```
serverless remove
```

## References

[AWS Scala library used in the project.](https://github.com/seratch/AWScala)
