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
                stash name: 'libs', includes: 'build/libs/crid-decoder-*.jar'
                stash name: 'docs', includes: 'build/docs/javadoc/**/*'
            }
        }

        stage('Publish') {
            agent { label 'docs' }
            when { branch 'master' }
            steps {
                unstash 'docs'
                sh '''
                    DEPLOY_DIR=/deploy/docs/crid-decoder
                    umask 022

                    mkdir -p "${DEPLOY_DIR}"
                    rm -rf "${DEPLOY_DIR}"/*
                    cp -R build/docs/javadoc/* "${DEPLOY_DIR}"
                '''

                unstash 'libs'
                sh '''
                    DEPLOY_DIR=/deploy/archive/crid-decoder
                    umask 022

                    mkdir -p "${DEPLOY_DIR}"
                    if git describe --exact-match HEAD; then
                        echo "In release!"
                        cp build/libs/crid-decoder-*.jar "${DEPLOY_DIR}"
                    else
                        echo "Not in release!"
                        cp build/libs/crid-decoder-*.jar "${DEPLOY_DIR}/crid-decoder-dev.jar"
                    fi
                '''
            }
        }
    }
}
