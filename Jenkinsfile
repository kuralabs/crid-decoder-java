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
                    ARTIFACT=$(ls build/libs/crid-decoder-*.jar)

                    if git describe --exact-match HEAD; then
                        PUBLISH=$(basename "${ARTIFACT}")
                    else
                        PUBLISH="crid-decoder-dev.jar"
                    fi

                    umask 022
                    mkdir -p "${DEPLOY_DIR}"
                    cp "${ARTIFACT}" "${DEPLOY_DIR}/${PUBLISH}"
                    sha256sum "${DEPLOY_DIR}/${PUBLISH}" > "${DEPLOY_DIR}/${PUBLISH}.sha256"
                '''
            }
        }
    }
}
