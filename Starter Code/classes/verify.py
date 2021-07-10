import os
import sys
'''
py verify.py <input-directory-path> <output-directory-path>
'''
indir,outdir=sys.argv[1],sys.argv[2]
allfiles=os.listdir(indir)

with open('log.txt','w+') as err:
    for file in allfiles:
        try:
            with open(os.path.join(outdir,file),'r+') as outp:
                
                stream = os.popen('java -cp ../classes/ FabricBreakup '+os.path.join(indir,file))
                output = stream.read()
                if output!=outp.read():
                    err.write(file+'\n')
        except:
            err.write(file+'\n')
