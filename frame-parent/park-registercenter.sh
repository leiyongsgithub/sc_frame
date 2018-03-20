#!/bin/sh
APP_MAINCLASS=cn.smart.park.RegisterCenterServer
APP_HOME=/opt/park-parent
PROJECT_NAME=park-registercenter
CLASSPATH=$APP_HOME/$PROJECT_NAME/classes
for i in $APP_HOME/$PROJECT_NAME/lib/*.jar; do
   CLASSPATH="$CLASSPATH":"$i"
done
JAVA_OPTS="-server -ms128m -mx128m -Xmn64m -Djava.awt.headless=true"
psid=0
started=0
checkpid() {
   javaps=`$JAVA_HOME/bin/jps -l | grep $APP_MAINCLASS`
   if [ -n "$javaps" ]; then
      psid=`echo $javaps | awk '{print $1}'`
   else
      psid=0
   fi
}


checkport(){
   configcenterport=`netstat -ln|grep 8000`
   if [ -n "$configcenterport" ]; then
      started=1
      sleep 10
   else
      started=0
      sleep 1
   fi
}


start() {
   checkpid
   if [ $psid -ne 0 ]; then
      echo "================================"
      echo "warn: $APP_MAINCLASS already started! (pid=$psid)"
      echo "================================"
   else
      echo "Starting $APP_MAINCLASS ..."
      nohup java $JAVA_OPTS -classpath $CLASSPATH $APP_MAINCLASS >/dev/null 2>&1 &
      checkpid
    	  if [ $PROJECT_NAME = "park-configcenter" ]; then
      while [ $started -eq 0 ]; do
        checkport
        echo "Waitting for server starting complete!"
        done
   fi
      if [ $psid -ne 0 ]; then
         echo "(pid=$psid) [OK]"
      else
         echo "[Failed]"
      fi
   fi
}

stop() {
   checkpid
   if [ $psid -ne 0 ]; then
      echo -n "Stopping $APP_MAINCLASS ...(pid=$psid) "
      kill -9 $psid
      if [ $? -eq 0 ]; then
         echo "[OK]"
      else
         echo "[Failed]"
      fi
      checkpid
      if [ $psid -ne 0 ]; then
         stop
      fi
   else
      echo "================================"
      echo "warn: $APP_MAINCLASS is not running"
      echo "================================"
   fi
}

status() {
   checkpid
   if [ $psid -ne 0 ];  then
      echo "$APP_MAINCLASS is running! (pid=$psid)"
   else
      echo "$APP_MAINCLASS is not running"
   fi
}

case "$1" in
   'start')
     start
     ;;
   'stop')
     stop
     ;;
   'restart')
     stop
     start
     ;;
   'status')
     status
     ;;
  *)
     echo "Usage: $0 {start|stop|restart|status}"
     exit 1
esac
exit 0
