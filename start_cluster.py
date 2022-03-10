#!/usr/bin/env python3.8

############################################################
#replace these values with the correct ones
USER = 'gmaurina'
STORM = '/s/chopin/a/grad/gmaurina/apache-storm-2.3.0'
ZOOKEEPER = 'albany'
NIMBUS = 'boston'
WORKERS = ['atlanta','augusta','austin', 'baton-rouge']
############################################################





'''
This script:
1. kills all nodes in the cluster
2. cleans all tmp folders
3. restarts all nodes
Be carefull because all processes of a the user on all nodes are killed
'''





from os import system
from itertools import zip_longest
NODES = ((ZOOKEEPER, 'zk-supervisord.conf'),(NIMBUS, 'nimbus-supervisord.conf')) + tuple(zip_longest(WORKERS, (), fillvalue='worker-supervisord.conf'))
KILLALL = f'killall -user {USER}'

def start_command(file):
    cmds = []
    cmds.append(f'rm -rf /tmp/{USER}-storm')
    cmds.append(f'mkdir /tmp/{USER}-storm')
    cmds.append(f'supervisord -c {STORM}/conf/{file}')
    return ' ; '.join(cmds)

def ssh_cmd(node, cmd):
    return f'ssh {node} "{cmd}"'

def main():
    for node, file in reversed(NODES):
        print('killing', node)
        system(ssh_cmd(node, KILLALL))
    for node, file in reversed(NODES):
        print('starting', node)
        system(ssh_cmd(node, start_command(file)))

if __name__ == '__main__':
    main()
