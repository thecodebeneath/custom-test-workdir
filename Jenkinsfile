pipeline {
    agent any
    tools {
        maven 'M3'
    }
    stages {
        stage('Preparation') {
            steps {
                git url:'git@github.com:thecodebeneath/custom-test-workdir.git',
                credentialsId: 'github'
            }
        }
        stage('Maven Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Git Info') {
            steps {
                sh 'git --version'
                sh 'git remote -v'
                sh 'git config --global user.name jenkinspipeline'
                sh 'git config --global user.email jenkins@pipeline.com'
            }
        }
        stage('Git Tag and Push Remote') {
            steps {
                sh 'echo "------------------" '
                sh 'echo "Note: as long as checkout is done with git@ and not https@, this works..." '
                sh 'echo "------------------" '
                sshagent (credentials: ['github']) {
                    sh('git tag -a $BUILD_ID -m "tag from jenkins" ')
                    sh('git push origin $BUILD_ID')
                }
            }
        }
        
    }
}
