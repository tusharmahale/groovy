def command="/PATH/TO/SCRIPT/OR/COMMAND"
def node='XXX' # AGENT name
def list=[]
list = hudson.util.RemotingDiagnostics.executeGroovy("""def p = '$command'.execute();p.waitFor();println p.in.text""", jenkins.model.Jenkins.instance.slaves.find { it.name == node }.channel)
return list.readLines().dropRight(1)
