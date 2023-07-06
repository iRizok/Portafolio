show PARAMETER sga;

alter system set sga_max_size = 500M scope=spfile;
alter system set sga_target = 300M scope=spfile;
shut inmediate
startup;
show parameter sga
