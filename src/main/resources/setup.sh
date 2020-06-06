
sudo amazon-linux-extras enable corretto8

sudo yum install java-1.8.0-amazon-corretto

chkconfig --add chrstartup

chkconfig chrstartup --level 1235 on
