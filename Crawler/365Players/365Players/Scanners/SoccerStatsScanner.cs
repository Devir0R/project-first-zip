using _365Players.Enums;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _365Players.Scanners
{
    public class SoccerStatsScanner : Scanner
    {
        public override string Name => "SoccerStatsScanner";
        private const string DATA_SOURCE = "SOCCER_STATS";

        public override bool Scan()
        {
            return true;
        }

        public override bool Scan(DateTime start, DateTime end)
        {
            return true;
        }

        
        public override void Start()
        {
            CPlayerUpdate playerUpdateTest = new CPlayerUpdate(DATA_SOURCE);
            playerUpdateTest.Name = "Maor Melikson";
            playerUpdateTest.Height = 1.75;
            playerUpdateTest.Country = "Israel";
            playerUpdateTest.DOB = new DateTime(1984, 10, 30);

            playerUpdateTest.Position = (int)ESoccerPlayerPositions.Midfield;
            playerUpdateTest.FormationPosition = (int)ESoccerPlayerFormationPositions.AM;

            var playerStat = new CPlayerIndividualStat();
            playerStat.StatisticType = (int)ESoccerPlayerStatistics.Goals;
            playerStat.Value = "1";
            List<CPlayerIndividualStat> playerStats = new List<CPlayerIndividualStat>() { playerStat };
            playerUpdateTest.Statistics.Add(new CAthleteStatisticsUpdate() { Stats = playerStats });

            playerUpdateTest.Competitions = new List<string> { "Israeli Premier League","Israeli FA Cup" };
            playerUpdateTest.Competitors = new List<string> { "Hapoel Beer Sheva", "Israel" };
            playerUpdateTest.JerseyNum = 24;
            playerUpdateTest.Nationalitys = new List<string> { "Poland", "Israel" };
            playerUpdateTest.Weight = 70;

            RaiseEvent(new List<CPlayerUpdate>() { playerUpdateTest });
        }

        public override void RaiseEvent(ICollection<CPlayerUpdate> Updates)
        {
            //send to db
        }
        public override void Stop()
        {
            throw new NotImplementedException();
        }
    }
}
