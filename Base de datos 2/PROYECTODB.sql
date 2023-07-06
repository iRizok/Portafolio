show parameter sga;
Alter system set sga size = 1200M scope = spfile;
alter system set sga target = 800M scope = spfile;
