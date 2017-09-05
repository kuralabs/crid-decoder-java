pipeline {
    agent none

    stages {
        stage('Build') {
            agent { docker { image 'kuralabs/java-dev:latest' } }
            steps {
                sh '''
                    gradle jar
                    gradle test
                    gradle doc
                '''
                stash name: 'docs', includes: 'build/docs/javadoc/**/*'
            }
        }

        stage('Publish') {
            agent { label 'docs' }
            when { branch 'master' }
            steps {
                unstash 'docs'
                sh '''
                    umask 022
                    mkdir -p /deploy/docs/crid-decoder
                    rm -rf /deploy/docs/crid-decoder/*
                    cp -R build/docs/javadoc/* /deploy/docs/crid-decoder/
                '''
            }
        }
    }
}
