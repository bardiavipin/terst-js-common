create index IX_9E3B9815 on Portlets_Events (labId, companyId);
create index IX_50FCF06F on Portlets_Events (labId, status, companyId);
create index IX_F98E7A9B on Portlets_Events (labId, userId, companyId);
create index IX_E9385129 on Portlets_Events (userId, companyId);
create index IX_106E3919 on Portlets_Events (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_63431DB on Portlets_Events (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_40DD7CA1 on Portlets_LabDetails (status, companyId);
create index IX_E96F06CD on Portlets_LabDetails (userId, companyId);
create index IX_31783EF5 on Portlets_LabDetails (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_127DFEB7 on Portlets_LabDetails (uuid_[$COLUMN_LENGTH:75$], groupId);