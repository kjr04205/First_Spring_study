-- select now(); -- 현재시간을 출력한다.
INSERT INTO user_info VALUES ('asdf', '1234', '안효인', 'aaa@bbb.com', '1997-11-05', 'fb', now());
select * from user_info;

-- Auto Commit
-- commit - 작업내용을 DB에 반영
-- rollback - 작업 내용을 되돌리는것. 이전 커밋 상태로(undo)

update user_info set pwd='1234', email='aaa@zzz.com' where id="asdf";

-- delete from user_info;