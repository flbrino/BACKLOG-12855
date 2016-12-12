package com.poc.spark.controller.conf;

import static com.poc.spark.controller.conf.IntInfinity.INFINITY;
import static com.poc.spark.controller.conf.RollingTimeInterval.DAILY;
import static com.poc.spark.controller.conf.SchedulingMode.FIFO;

/**
 * Created by fcamara
 */
public enum SparkConfEntryDefaults implements ConfEntry{

    //Application Properties
    SPARK_APP_NAME("spark.app.name", null),
    SPARK_DRIVER_CORES("spark.driver.cores", 1),
    SPARK_DRIVER_MAXRESULTSIZE("spark.driver.maxResultSize", "1g"),
    SPARK_DRIVER_MEMORY("spark.driver.memory", "1g"),
    SPARK_EXECUTOR_MEMORY("spark.executor.memory", "1g"),
    SPARK_LOCAL_DIR("spark.local.dir", "/tmp"),
    SPARK_EXTRALISTENERS("spark.extraListeners", null),
    SPARK_LOGCONF("spark.logConf", null),
    SPARK_MASTER("spark.master", null),
    SPARK_SUBMIT_DEPLOYMODE("spark.submit.deployMode", null),

    //Runtime Environment
    SPARK_DRIVER_EXTRACLASSPATH("spark.driver.extraClassPath", null),
    SPARK_DRIVER_EXTRAJAVAOPTIONS("spark.driver.extraJavaOptions", null),
    SPARK_DRIVER_EXTRALIBRARYPATH("spark.driver.extraLibraryPath", null),
    SPARK_DRIVER_USERCLASSPATHFIRST("spark.driver.userClassPathFirst", null),
    SPARK_EXECUTOR_EXTRACLASSPATH("spark.executor.extraClassPath", null),
    SPARK_EXECUTOR_EXTRAJAVAOPTIONS("spark.executor.extraJavaOptions", null),
    SPARK_EXECUTOR_EXTRALIBRARYPATH("spark.executor.extraLibraryPath", null),
    SPARK_EXECUTOR_LOGS_ROLLING_MAXRETAINEDFILES("spark.executor.logs.rolling.maxRetainedFiles", null),
    SPARK_EXECUTOR_LOGS_ROLLING_ENABLECOMPRESSION("spark.executor.logs.rolling.enableCompression", Boolean.FALSE),
    SPARK_EXECUTOR_LOGS_ROLLING_MAXSIZE("spark.executor.logs.rolling.maxSize", null),
    SPARK_EXECUTOR_LOGS_ROLLING_STRATEGY("spark.executor.logs.rolling.strategy", null),
    SPARK_EXECUTOR_LOGS_ROLLING_TIME_INTERVAL("spark.executor.logs.rolling.time.interval", DAILY),
    SPARK_EXECUTOR_USERCLASSPATHFIRST("spark.executor.userClassPathFirst", Boolean.FALSE),
    SPARK_EXECUTORENV_EnvironmentVariableName("spark.executorEnv.", null),
    SPARK_PYTHON_PROFILE("spark.python.profile", Boolean.FALSE),
    SPARK_PYTHON_PROFILE_DUMP("spark.python.profile.dump", null),
    SPARK_PYTHON_WORKER_MEMORY("spark.python.worker.memory", null),
    SPARK_PYTHON_WORKER_REUSE("spark.python.worker.reuse", Boolean.TRUE),
    SPARK_FILES("spark.files", null),
    SPARK_SUBMIT_PYFILES("spark.submit.pyFiles", null),
    SPARK_JARS("spark.jars", null),
    SPARK_JARS_PACKAGES("spark.jars.packages", null),
    SPARK_JARS_EXCLUDES("spark.jars.excludes", null),
    SPARK_JARS_IVY("spark.jars.ivy", null),

    //Shuffle Behavior
    SPARK_REDUCER_MAXSIZEINFLIGHT("spark.reducer.maxSizeInFlight", "48m"),
    SPARK_REDUCER_MAXREQSINFLIGHT("spark.reducer.maxReqsInFlight", Integer.MAX_VALUE),
    SPARK_SHUFFLE_COMPRESS("spark.shuffle.compress", Boolean.TRUE),
    SPARK_SHUFFLE_FILE_BUFFER("spark.shuffle.file.buffer", "32k"),
    SPARK_SHUFFLE_IO_MAXRETRIES("spark.shuffle.io.maxRetries", 3),
    SPARK_SHUFFLE_IO_NUMCONNECTIONSPERPEER("spark.shuffle.io.numConnectionsPerPeer", 1),
    SPARK_SHUFFLE_IO_PREFERDIRECTBUFS("spark.shuffle.io.preferDirectBufs", Boolean.TRUE),
    SPARK_SHUFFLE_IO_RETRYWAIT("spark.shuffle.io.retryWait", "5s"),
    SPARK_SHUFFLE_SERVICE_ENABLED("spark.shuffle.service.enabled", Boolean.FALSE),
    SPARK_SHUFFLE_SERVICE_PORT("spark.shuffle.service.port", "7337"),
    SPARK_SHUFFLE_SORT_BYPASSMERGETHRESHOLD("spark.shuffle.sort.bypassMergeThreshold", "200"),
    SPARK_SHUFFLE_SPILL_COMPRESS("spark.shuffle.spill.compress", Boolean.TRUE),

    //Spark UI Properties
    SPARK_EVENTLOG_COMPRESS("spark.eventLog.compress", Boolean.FALSE),
    SPARK_EVENTLOG_DIR("spark.eventLog.dir", "file:///tmp/spark-events"),
    SPARK_EVENTLOG_ENABLED("spark.eventLog.enabled", Boolean.FALSE),
    SPARK_UI_KILLENABLED("spark.ui.killEnabled", Boolean.TRUE),
    SPARK_UI_PORT("spark.ui.port", 4040),
    SPARK_UI_RETAINEDJOBS("spark.ui.retainedJobs", 1000),
    SPARK_UI_RETAINEDSTAGES("spark.ui.retainedStages", 1000),
    SPARK_UI_RETAINEDTASKS("spark.ui.retainedTasks", 100000),
    SPARK_WORKER_UI_RETAINEDEXECUTORS("spark.worker.ui.retainedExecutors", 1000),
    SPARK_WORKER_UI_RETAINEDDRIVERS("spark.worker.ui.retainedDrivers", 1000),
    SPARK_SQL_UI_RETAINEDEXECUTIONS("spark.sql.ui.retainedExecutions", 1000),
    //SPARK_STREAMING_UI_RETAINEDBATCHES("spark.streaming.ui.retainedBatches", 1000),
    SPARK_UI_RETAINEDDEADEXECUTORS("spark.ui.retainedDeadExecutors", 1000),

    //Compression Serialization
    SPARK_BROADCAST_COMPRESS("spark.broadcast.compress", Boolean.TRUE),
    SPARK_IO_COMPRESSION_CODEC("spark.io.compression.codec", "lz4"),
    SPARK_IO_COMPRESSION_LZ4_BLOCKSIZE("spark.io.compression.lz4.blockSize", "32k"),
    SPARK_IO_COMPRESSION_SNAPPY_BLOCKSIZE("spark.io.compression.snappy.blockSize", "32k"),
    SPARK_KRYO_CLASSESTOREGISTER("spark.kryo.classesToRegister", null),
    SPARK_KRYO_REFERENCETRACKING("spark.kryo.referenceTracking", Boolean.TRUE),
    SPARK_KRYO_REGISTRATIONREQUIRED("spark.kryo.registrationRequired", Boolean.FALSE),
    SPARK_KRYO_REGISTRATOR("spark.kryo.registrator", null),
    SPARK_KRYOSERIALIZER_BUFFER_MAX("spark.kryoserializer.buffer.max", "64m"),
    SPARK_KRYOSERIALIZER_BUFFER("spark.kryoserializer.buffer", "64k"),
    SPARK_RDD_COMPRESS("spark.rdd.compress", Boolean.FALSE),
    SPARK_SERIALIZER("spark.serializer", "org.apache.spark.serializer.JavaSerializer"),
    SPARK_SERIALIZER_OBJECTSTREAMRESET("spark.serializer.objectStreamReset", 100),

    //Memory Management
    SPARK_MEMORY_FRACTION("spark.memory.fraction", "0.6"),
    SPARK_MEMORY_STORAGEFRACTION("spark.memory.storageFraction", "0.5"),
    SPARK_MEMORY_OFFHEAP_ENABLED("spark.memory.offHeap.enabled", Boolean.FALSE),
    SPARK_MEMORY_OFFHEAP_SIZE("spark.memory.offHeap.size", 0),
    SPARK_MEMORY_USELEGACYMODE("spark.memory.useLegacyMode", Boolean.FALSE),
    SPARK_SHUFFLE_MEMORYFRACTION("spark.shuffle.memoryFraction", "0.2"),
    SPARK_STORAGE_MEMORYFRACTION("spark.storage.memoryFraction", "0.6"),
    SPARK_STORAGE_UNROLLFRACTION("spark.storage.unrollFraction", "0.2"),

    //Execution Behavior
    SPARK_BROADCAST_BLOCKSIZE("spark.broadcast.blockSize", "4m"),
    //SPARK_EXECUTOR_CORES("spark.executor.cores", 1),
    SPARK_DEFAULT_PARALLELISM("spark.default.parallelism", null),
    SPARK_EXECUTOR_HEARTBEATINTERVAL("spark.executor.heartbeatInterval", "10s"),
    SPARK_FILES_FETCHTIMEOUT("spark.files.fetchTimeout", "60s"),
    SPARK_FILES_USEFETCHCACHE("spark.files.useFetchCache", Boolean.FALSE),
    SPARK_FILES_OVERWRITE("spark.files.overwrite", Boolean.FALSE),
    SPARK_HADOOP_CLONECONF("spark.hadoop.cloneConf", Boolean.FALSE),
    SPARK_HADOOP_VALIDATEOUTPUTSPECS("spark.hadoop.validateOutputSpecs", Boolean.TRUE),
    SPARK_STORAGE_MEMORYMAPTHRESHOLD("spark.storage.memoryMapThreshold", "2m"),

    //Networking
    SPARK_RPC_MESSAGE_MAXSIZE("spark.rpc.message.maxSize", 128),
    SPARK_BLOCKMANAGER_PORT("spark.blockManager.port", null),
    SPARK_DRIVER_HOST("spark.driver.host", null),
    SPARK_DRIVER_PORT("spark.driver.port", null),
    SPARK_NETWORK_TIMEOUT("spark.network.timeout", "120s"),
    SPARK_PORT_MAXRETRIES("spark.port.maxRetries", 16),
    SPARK_RPC_NUMRETRIES("spark.rpc.numRetries", 3),
    SPARK_RPC_RETRY_WAIT("spark.rpc.retry.wait", "3s"),
    SPARK_RPC_ASKTIMEOUT("spark.rpc.askTimeout", "120s"),
    SPARK_RPC_LOOKUPTIMEOUT("spark.rpc.lookupTimeout", "120s"),

    //Scheduling
    SPARK_CORES_MAX("spark.cores.max", null),
    SPARK_LOCALITY_WAIT("spark.locality.wait", "3s"),
    SPARK_LOCALITY_WAIT_NODE("spark.locality.wait.node", "spark.locality.wait"),
    SPARK_LOCALITY_WAIT_PROCESS("spark.locality.wait.process", "spark.locality.wait"),
    SPARK_LOCALITY_WAIT_RACK("spark.locality.wait.rack", null),
    SPARK_SCHEDULER_MAXREGISTEREDRESOURCESWAITINGTIME("spark.scheduler.maxRegisteredResourcesWaitingTime", "30s"),
    SPARK_SCHEDULER_MINREGISTEREDRESOURCESRATIO("spark.scheduler.minRegisteredResourcesRatio", "0.8"),
    SPARK_SCHEDULER_MODE("spark.scheduler.mode", FIFO),
    SPARK_SCHEDULER_REVIVE_INTERVAL("spark.scheduler.revive.interval", "1s"),
    SPARK_SPECULATION("spark.speculation", Boolean.FALSE),
    SPARK_SPECULATION_INTERVAL("spark.speculation.interval", "100ms"),
    SPARK_SPECULATION_MULTIPLIER("spark.speculation.multiplier", "1.5"),
    SPARK_SPECULATION_QUANTILE("spark.speculation.quantile", "0.75"),
    SPARK_TASK_CPUS("spark.task.cpus", 1),
    SPARK_TASK_MAXFAILURES("spark.task.maxFailures", 4),

    //Dynamic Allocation
    SPARK_DYNAMICALLOCATION_ENABLED("spark.dynamicAllocation.enabled", Boolean.FALSE),
    SPARK_DYNAMICALLOCATION_EXECUTORIDLETIMEOUT("spark.dynamicAllocation.executorIdleTimeout", "60s"),
    SPARK_DYNAMICALLOCATION_CACHEDEXECUTORIDLETIMEOUT("spark.dynamicAllocation.cachedExecutorIdleTimeout", INFINITY),
    SPARK_DYNAMICALLOCATION_INITIALEXECUTORS("spark.dynamicAllocation.initialExecutors", "spark.dynamicAllocation.minExecutors"),
    SPARK_DYNAMICALLOCATION_MAXEXECUTORS("spark.dynamicAllocation.maxExecutors", INFINITY),
    SPARK_DYNAMICALLOCATION_MINEXECUTORS("spark.dynamicAllocation.minExecutors", 0),
    SPARK_DYNAMICALLOCATION_SCHEDULERBACKLOGTIMEOUT("spark.dynamicAllocation.schedulerBacklogTimeout", "1s"),
    SPARK_DYNAMICALLOCATION_SUSTAINEDSCHEDULERBACKLOGTIMEOUT("spark.dynamicAllocation.sustainedSchedulerBacklogTimeout", "schedulerBacklogTimeout"),

    //Security
    SPARK_ACLS_ENABLE("spark.acls.enable", Boolean.FALSE),
    SPARK_ADMIN_ACLS("spark.admin.acls", ""),
    SPARK_ADMIN_ACLS_GROUPS("spark.admin.acls.groups", ""),
    SPARK_USER_GROUPS_MAPPING("spark.user.groups.mapping", "org.apache.spark.security.ShellBasedGroupsMappingProvider"),
    SPARK_AUTHENTICATE("spark.authenticate", Boolean.FALSE),
    SPARK_AUTHENTICATE_SECRET("spark.authenticate.secret", ""),
    SPARK_AUTHENTICATE_ENABLESASLENCRYPTION("spark.authenticate.enableSaslEncryption", Boolean.FALSE),
    SPARK_NETWORK_SASL_SERVERALWAYSENCRYPT("spark.network.sasl.serverAlwaysEncrypt", Boolean.FALSE),
    SPARK_CORE_CONNECTION_ACK_WAIT_TIMEOUT("spark.core.connection.ack.wait.timeout", "60s"),
    SPARK_CORE_CONNECTION_AUTH_WAIT_TIMEOUT("spark.core.connection.auth.wait.timeout", "30s"),
    SPARK_MODIFY_ACLS("spark.modify.acls", ""),
    SPARK_MODIFY_ACLS_GROUPS("spark.modify.acls.groups", ""),
    SPARK_UI_FILTERS("spark.ui.filters", null),
    SPARK_UI_VIEW_ACLS("spark.ui.view.acls", ""),
    SPARK_UI_VIEW_ACLS_GROUPS("spark.ui.view.acls.groups", ""),

    //Encription
    SPARK_SSL_ENABLED("spark.ssl.enabled", Boolean.FALSE),
    SPARK_SSL_ENABLEDALGORITHMS("spark.ssl.enabledAlgorithms", ""),
    SPARK_SSL_KEYPASSWORD("spark.ssl.keyPassword", null),
    SPARK_SSL_KEYSTORE("spark.ssl.keyStore", "JKS"),
    SPARK_SSL_KEYSTOREPASSWORD("spark.ssl.keyStorePassword", null),
    SPARK_SSL_KEYSTORETYPE("spark.ssl.keyStoreType", null),
    SPARK_SSL_PROTOCOL("spark.ssl.protocol", null),
    SPARK_SSL_NEEDCLIENTAUTH("spark.ssl.needClientAuth", Boolean.FALSE),
    SPARK_SSL_TRUSTSTORE("spark.ssl.trustStore", null),
    SPARK_SSL_TRUSTSTOREPASSWORD("spark.ssl.trustStorePassword", null),
    SPARK_SSL_TRUSTSTORETYPE("spark.ssl.trustStoreType", "JKS"),

    //Spark Streaming
    SPARK_STREAMING_BACKPRESSURE_ENABLED("spark.streaming.backpressure.enabled", Boolean.FALSE ),
    SPARK_STREAMING_BACKPRESSURE_INITIALRATE("spark.streaming.backpressure.initialRate", null),
    SPARK_STREAMING_BLOCKINTERVAL("spark.streaming.blockInterval", "200ms"),
    SPARK_STREAMING_RECEIVER_MAXRATE("spark.streaming.receiver.maxRate", null),
    SPARK_STREAMING_RECEIVER_WRITEAHEADLOG_ENABLE("spark.streaming.receiver.writeAheadLog.enable", Boolean.FALSE),
    SPARK_STREAMING_UNPERSIST("spark.streaming.unpersist", Boolean.TRUE),
    SPARK_STREAMING_STOPGRACEFULLYONSHUTDOWN("spark.streaming.stopGracefullyOnShutdown", Boolean.FALSE),
    SPARK_STREAMING_KAFKA_MAXRATEPERPARTITION("spark.streaming.kafka.maxRatePerPartition", null),
    SPARK_STREAMING_KAFKA_MAXRETRIES("spark.streaming.kafka.maxRetries", 1),
    SPARK_STREAMING_UI_RETAINEDBATCHES("spark.streaming.ui.retainedBatches", 1000),
    SPARK_STREAMING_DRIVER_WRITEAHEADLOG_CLOSEFILEAFTERWRITE("spark.streaming.driver.writeAheadLog.closeFileAfterWrite", Boolean.FALSE),
    SPARK_STREAMING_RECEIVER_WRITEAHEADLOG_CLOSEFILEAFTERWRITE("spark.streaming.receiver.writeAheadLog.closeFileAfterWrite", Boolean.FALSE),

    //Spark R
    SPARK_R_NUM_BACKEND_THREADS("spark.r.numRBackendThreads", 2),
    SPARK_R_COMMAND("spark.r.command", "Rscript"),
    SPARK_R_DRIVER_COMMAND("spark.r.driver.command", "spark.r.command"),

    //Cluster Managers - YARN
    SPARK_YARN_AM_MEMORY("spark.yarn.am.memory", "512m"),
    //SPARK_DRIVER_MEMORY("spark.driver.memory", null),
    //SPARK_DRIVER_CORES("spark.driver.cores", 1),
    SPARK_YARN_AM_CORES("spark.yarn.am.cores", null),
    SPARK_YARN_AM_WAITTIME("spark.yarn.am.waitTime", "100s"),
    SPARK_YARN_SUBMIT_FILE_REPLICATION("spark.yarn.submit.file.replication", 3),
    SPARK_YARN_STAGINGDIR("spark.yarn.stagingDir", null),
    SPARK_YARN_PRESERVE_STAGING_FILES("spark.yarn.preserve.staging.files", Boolean.FALSE),
    SPARK_YARN_SCHEDULER_HEARTBEAT_INTERVAL_MS("spark.yarn.scheduler.heartbeat.interval-ms", 3000),
    SPARK_YARN_SCHEDULER_INITIAL_ALLOCATION_INTERVAL("spark.yarn.scheduler.initial-allocation.interval", "200ms"),
    SPARK_YARN_MAX_EXECUTOR_FAILURES("spark.yarn.max.executor.failures", 3), //numExecutors * 2, with minimum of 3
    SPARK_YARN_HISTORYSERVER_ADDRESS("spark.yarn.historyServer.address", null),
    SPARK_YARN_DIST_ARCHIVES("spark.yarn.dist.archives", null),
    SPARK_YARN_DIST_FILES("spark.yarn.dist.files", null),
    SPARK_YARN_DIST_JARS("spark.yarn.dist.jars", null),
    SPARK_EXECUTOR_CORES("spark.executor.cores", 1),
    SPARK_EXECUTOR_INSTANCES("spark.executor.instances", 2),
    //SPARK_EXECUTOR_MEMORY("spark.executor.memory", null),
    SPARK_YARN_EXECUTOR_MEMORYOVERHEAD("spark.yarn.executor.memoryOverhead", "1g"),
    SPARK_YARN_DRIVER_MEMORYOVERHEAD("spark.yarn.driver.memoryOverhead", null),
    SPARK_YARN_AM_MEMORYOVERHEAD("spark.yarn.am.memoryOverhead", null),
    SPARK_YARN_AM_PORT("spark.yarn.am.port", null),
    SPARK_YARN_QUEUE("spark.yarn.queue", "default"),
    SPARK_YARN_JARS("spark.yarn.jars", null),
    SPARK_YARN_ARCHIVE("spark.yarn.archive", null),
    SPARK_YARN_ACCESS_NAMENODES("spark.yarn.access.namenodes", null),
    SPARK_YARN_APPMASTERENV_EnvironmentVariableName("spark.yarn.appMasterEnv.", null),
    SPARK_YARN_CONTAINERLAUNCHERMAXTHREADS("spark.yarn.containerLauncherMaxThreads", 25),
    SPARK_YARN_AM_EXTRAJAVAOPTIONS("spark.yarn.am.extraJavaOptions", null),
    SPARK_YARN_AM_EXTRALIBRARYPATH("spark.yarn.am.extraLibraryPath", null),
    SPARK_YARN_MAXAPPATTEMPTS("spark.yarn.maxAppAttempts", null),
    SPARK_YARN_AM_ATTEMPTFAILURESVALIDITYINTERVAL("spark.yarn.am.attemptFailuresValidityInterval", null),
    SPARK_YARN_EXECUTOR_FAILURESVALIDITYINTERVAL("spark.yarn.executor.failuresValidityInterval", null),
    SPARK_YARN_SUBMIT_WAITAPPCOMPLETION("spark.yarn.submit.waitAppCompletion", Boolean.TRUE),
    SPARK_YARN_AM_NODELABELEXPRESSION("spark.yarn.am.nodeLabelExpression", null),
    SPARK_YARN_EXECUTOR_NODELABELEXPRESSION("spark.yarn.executor.nodeLabelExpression", null),
    SPARK_YARN_TAGS("spark.yarn.tags", null),
    SPARK_YARN_KEYTAB("spark.yarn.keytab", null),
    SPARK_YARN_PRINCIPAL("spark.yarn.principal", null),
    SPARK_YARN_CONFIG_GATEWAYPATH("spark.yarn.config.gatewayPath", null),
    SPARK_YARN_CONFIG_REPLACEMENTPATH("spark.yarn.config.replacementPath", null),
    SPARK_YARN_SECURITY_TOKENS_SERVICE_ENABLED("spark.yarn.security.tokens.${service}.enabled", null),

    //Mesos
    SPARK_MESOS_COARSE("spark.mesos.coarse", Boolean.TRUE),
    SPARK_MESOS_EXTRA_CORES("spark.mesos.extra.cores", 0),
    SPARK_MESOS_MESOSEXECUTOR_CORES("spark.mesos.mesosExecutor.cores", "1.0"),
    SPARK_MESOS_EXECUTOR_DOCKER_IMAGE("spark.mesos.executor.docker.image", null),
    SPARK_MESOS_EXECUTOR_DOCKER_VOLUMES("spark.mesos.executor.docker.volumes", null),
    SPARK_MESOS_EXECUTOR_HOME("spark.mesos.executor.home", null),
    SPARK_MESOS_EXECUTOR_MEMORYOVERHEAD("spark.mesos.executor.memoryOverhead", 384),//executor memory * 0.10, with minimum of 384
    SPARK_MESOS_URIS("spark.mesos.uris", null),
    SPARK_MESOS_PRINCIPAL("spark.mesos.principal", null),
    SPARK_MESOS_SECRET("spark.mesos.secret", null),
    SPARK_MESOS_ROLE("spark.mesos.role", "*"),
    SPARK_MESOS_CONSTRAINTS("spark.mesos.constraints", null),
    SPARK_MESOS_DRIVER_WEBUI_URL("spark.mesos.driver.webui.url", null),
    SPARK_MESOS_DISPATCHER_WEBUI_URL("spark.mesos.dispatcher.webui.url", null),

    //Standalone Mode
    //Master
    SPARK_DEPLOY_RETAINEDAPPLICATIONS("spark.deploy.retainedApplications", 200),
    SPARK_DEPLOY_RETAINEDDRIVERS("spark.deploy.retainedDrivers", 200),
    SPARK_DEPLOY_SPREADOUT("spark.deploy.spreadOut", Boolean.TRUE),
    SPARK_DEPLOY_DEFAULTCORES("spark.deploy.defaultCores", INFINITY),
    SPARK_DEPLOY_MAXEXECUTORRETRIES("spark.deploy.maxExecutorRetries", 10),
    SPARK_WORKER_TIMEOUT("spark.worker.timeout", 60),
    //worker
    SPARK_WORKER_CLEANUP_ENABLED("spark.worker.cleanup.enabled", Boolean.FALSE),
    SPARK_WORKER_CLEANUP_INTERVAL("spark.worker.cleanup.interval", 1800),
    SPARK_WORKER_CLEANUP_APPDATATTL("spark.worker.cleanup.appDataTtl", 7 * 24 * 3600),
    SPARK_WORKER_UI_COMPRESSEDLOGFILELENGTHCACHESIZE("spark.worker.ui.compressedLogFileLengthCacheSize", 100);

    private String key;
    private Object defaultValue;

    private SparkConfEntryDefaults(String key, Object defaultValue) {
      this.key = key;
      this.defaultValue = defaultValue;
    }

    @Override
    public String key() { return key; }

    @Override
    public Object defaultValue() { return defaultValue; }

}
