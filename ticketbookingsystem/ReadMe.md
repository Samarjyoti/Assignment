The following API is designed for the ticket booking system
Also following users are created for basic authentication:

Users:
1. user1, password: pass
2. user2, password: pass

API:
1. /movie (@GET) : To get the movie lists
sample json output: [{"id":1,"name":"MI-5", "ticketPrice":"300"}]

2. /movie (@POST): To create a new movie
sample json: {"name":"MI-6", "ticketPrice":"300"}

3. /movie/{movieId}/ticket (@GET) : To get the list of tickets for movie {movieID}

4. /movie/{movieId}/ticket/{ticketId} (@POST) : To book a ticket, which is locked for two mintues from the time of booking

